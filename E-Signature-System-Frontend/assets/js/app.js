// Simple front-end demo state (stored in memory)
const state = {
  users: [{id:1, username:'Manjari', role:'SIGNER'}],
  docs: [{id:2, filename:'sample.pdf', ownerId:0, status:'UPLOADED'},
         {id:3, filename:'adob.pdf', ownerId:1, status:'UPLOADED'}],
  signatures: []
};

function renderUsers(){
  const ul = document.getElementById('usersList');
  if(!ul) return;
  ul.innerHTML = '';
  state.users.forEach(u => {
    const li = document.createElement('li');
    li.textContent = `ID:${u.id} | ${u.username} | ${u.role}`;
    ul.appendChild(li);
  });
  const dc = document.getElementById('docCount'); if(dc) dc.textContent = state.docs.length;
  const sc = document.getElementById('sigCount'); if(sc) sc.textContent = state.signatures.length;
}

function initAdmin(){
  renderUsers();
  const form = document.getElementById('addUserForm');
  if(!form) return;
  form.addEventListener('submit', (e)=>{
    e.preventDefault();
    const name = document.getElementById('u_name').value || 'user'+(state.users.length+1);
    const pass = document.getElementById('u_pass').value;
    const role = document.getElementById('u_role').value;
    const id = state.users.length? state.users[state.users.length-1].id+1:1;
    state.users.push({id, username:name, role});
    renderUsers();
    form.reset();
    alert('User added (demo): ' + name);
  });
}

function initSigner(){
  const form = document.getElementById('uploadForm');
  if(form){
    form.addEventListener('submit',(e)=>{
      e.preventDefault();
      const filename = document.getElementById('filename').value || 'untitled.pdf';
      const id = state.docs.length? state.docs[state.docs.length-1].id+1:1;
      state.docs.push({id, filename, ownerId:1, status:'UPLOADED'});
      populateDocsTable();
      alert('Document uploaded (demo): ' + filename);
      form.reset();
    });
  }
  populateDocsTable();
}

function populateDocsTable(){
  const tbody = document.querySelector('#docsTable tbody');
  if(!tbody) return;
  tbody.innerHTML = '';
  state.docs.forEach(d=>{
    const tr = document.createElement('tr');
    tr.innerHTML = `<td>${d.id}</td><td>${d.filename}</td><td>${d.status}</td>
      <td><button class="btn" onclick="signDocPrompt(${d.id})">Sign</button></td>`;
    tbody.appendChild(tr);
  });
}

function signDocPrompt(id){
  const signer = prompt('Signer name (demo):','Signer1');
  if(!signer) return;
  const sigId = state.signatures.length? state.signatures[state.signatures.length-1].id+1:1;
  state.signatures.push({id:sigId, documentId:id, signerName:signer, verified:false});
  alert('Document signed (demo). Signature ID: ' + sigId);
  populateDocsTable();
}

function initReviewer(){
  const ul = document.getElementById('pendingList');
  if(ul){
    ul.innerHTML = '';
    state.signatures.forEach(s=>{
      const li = document.createElement('li');
      li.textContent = `SigID:${s.id} | Doc:${s.documentId} | By:${s.signerName} | Verified:${s.verified}`;
      ul.appendChild(li);
    });
  }
  const btn = document.getElementById('verifyBtn');
  if(btn){
    btn.addEventListener('click', ()=>{
      const id = parseInt(document.getElementById('verifyId').value,10);
      const el = document.getElementById('verifyResult');
      const sig = state.signatures.find(x=>x.id===id);
      if(sig){
        sig.verified = true;
        el.textContent = 'Verified: Signature valid. Signed by: ' + sig.signerName;
      } else el.textContent = 'Signature ID not found.';
    });
  }
}

function initReviewPage(){
  const ul = document.getElementById('allSigs');
  if(!ul) return;
  ul.innerHTML = '';
  state.signatures.forEach(s=>{
    const li = document.createElement('li');
    li.textContent = `ID:${s.id} | Doc:${s.documentId} | By:${s.signerName} | Verified:${s.verified}`;
    ul.appendChild(li);
  });
}

// Auto-init per page
document.addEventListener('DOMContentLoaded', ()=>{
  initAdmin(); initSigner(); initReviewer(); initReviewPage(); populateDocsTable(); renderUsers();
});
