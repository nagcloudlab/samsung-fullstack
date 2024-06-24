


//----------------------------------------------
// using DOM Api
//----------------------------------------------

const card = document.querySelector('.card');
const cardHeader = document.querySelector('.card-header');
const cardBody = document.querySelector('.card-body');

const greetMeBtn = document.querySelector('.btn-primary');
const hideBtn = document.querySelector('.btn-danger');
const showBtn = document.querySelector('.btn-success');

greetMeBtn.addEventListener('click', e => {
    cardBody.innerText = 'Hello World!';
})

hideBtn.addEventListener('click', e => {
    card.style.display = 'none';
})

showBtn.addEventListener('click', e => {
    card.style.display = 'block';
})

//----------------------------------------------
// using DOM Api + XHR ( XmlHttpRequest ) Api
//----------------------------------------------

// const top5TodosBtn = document.querySelector('#top5-todos-btn');
// const todosTableBody = document.querySelector('#todos');
// const messageSpan = document.querySelector('#message');

// top5TodosBtn.addEventListener('click', e => {
//     const xhr = new XMLHttpRequest();
//     const httpMethod = 'GET';
//     const url = 'https://jsonplaceholder.typicode.com/todos?_limit=5';
//     const async = true;
//     xhr.open(httpMethod, url, async);
//     xhr.send();
//     messageSpan.innerText = 'Loading...';
//     xhr.onreadystatechange = () => {
//         if (xhr.readyState === 4 && xhr.status === 200) {
//             const todos = JSON.parse(xhr.responseText);
//             let todosHtml = '';
//             todos.forEach(todo => {
//                 todosHtml += `
//                     <tr>
//                         <td>${todo.id}</td>
//                         <td>${todo.title}</td>
//                         <td>${todo.completed}</td>
//                     </tr>
//                 `;
//             });
//             todosTableBody.innerHTML = todosHtml;
//             messageSpan.innerText = '';
//         }
//     }
// });


//----------------------------------------------
// using DOM Api + Fetch Api
//----------------------------------------------

// const top5TodosBtn = document.querySelector('#top5-todos-btn');
// const todosTableBody = document.querySelector('#todos');
// const messageSpan = document.querySelector('#message');

// top5TodosBtn.addEventListener('click', e => {
//     const url = 'https://jsonplaceholder.typicode.com/todos?_limit=5';
//     messageSpan.innerText = 'Loading...';
//     fetch(url, { method: 'GET' })
//         .then(response => response.json())
//         .then(todos => {
//             let todosHtml = '';
//             todos.forEach(todo => {
//                 todosHtml += `
//                     <tr>
//                         <td>${todo.id}</td>
//                         <td>${todo.title}</td>
//                         <td>${todo.completed}</td>
//                     </tr>
//                 `;
//             });
//             todosTableBody.innerHTML = todosHtml;
//             messageSpan.innerText = '';
//         })
//         .catch(err => {
//             messageSpan.innerText = 'Failed to load data!';
//         })
// });



//----------------------------------------------
// using DOM Api + Fetch Api + Async/Await
//----------------------------------------------

const top5TodosBtn = document.querySelector('#top5-todos-btn');
const todosTableBody = document.querySelector('#todos');
const messageSpan = document.querySelector('#message');

top5TodosBtn.addEventListener('click', async e => {
    const url = 'https://jsonplaceholder.typicode.com/todos?_limit=5';
    messageSpan.innerText = 'Loading...';
    try {
        const response = await fetch(url, { method: 'GET' });
        const todos = await response.json();
        let todosHtml = '';
        todos.forEach(todo => {
            todosHtml += `
                <tr>
                    <td>${todo.id}</td>
                    <td>${todo.title}</td>
                    <td>${todo.completed}</td>
                </tr>
            `;
        });
        todosTableBody.innerHTML = todosHtml;
        messageSpan.innerText = '';
    } catch (err) {
        messageSpan.innerText = 'Failed to load data!';
    }
});


//----------------------------------------------
// using DOM Api + Timer Api
//----------------------------------------------

const timerDisplay = document.querySelector('#timer');

setInterval(() => {
    timerDisplay.innerText = new Date().toLocaleTimeString('en-US', { timeZone: 'Asia/Kolkata' });
}, 1000);