const allUsuarios = () => {
    fetch("http://localhost:8080/usuario", { METHOD: "Get" }).then(response => response.json())
}

const readMensagens = (idSender, idReceiver) => {

    let mensagens;

    fetch(`http://localhost:8080/mensagem/${idSender}/${idReceiver} `, {method:"get"}).then(response => response.json()).then(data => mensagens = data)

    return mensagens;
}

const logar = (form) => {

    let response;
    fetch(form.action, {method:"post",body:new FormData(form)}).then(response => response.json()).then(data => response = data)

    return response;
}

const cadastrar = (form) => {
    let response
    fetch(form.action, {method:"post",body:new FormData(form)}).then(responseEntity => {
        response = responseEntity;
      });
    return response;
}






