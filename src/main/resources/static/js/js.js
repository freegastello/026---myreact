document.addEventListener('DOMContentLoaded', function () {

    // const but = document.querySelector('#objtest');
    // but.addEventListener('mousedown', function() {
    //     const request = new XMLHttpRequest();
    //     const url = "/objtest";
    //
    //     const id_product = "id";
    //     const qty_product = "qty";
    //     const params = "id_product=" + id_product + "&qty_product=" + qty_product;
    //
    //     // Здесь нужно указать в каком формате мы будем принимать данные вот и все	отличие
    //     // request.responseType = "json";
    //     request.open("POST", url, true);
    //     request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    //     request.addEventListener("readystatechange", function() {
    //         if (request.readyState === 4 && request.status === 200) {
    //             // let obj = request.response;// так всё выводит сплошным текстом
    //             //const list = eval("(" + request.responseText + ")");// Обязательно обрабатывать!!!
    //         }
    //     });
    //     request.send(params);
    // });




    // // 1 GET
    const button = document.querySelector('#btnget');
    button.addEventListener('mousedown', function() {
        const id_product_get  = "abc_get";
        const qty_product_get = "def_get";
        // const request = new XMLHttpRequest();
        const url = "/objtestget?id_product=" + id_product_get + "&qty_product=" + qty_product_get;
        sendRequest('GET', url);
    });

    // 2 POST
    const buttonpost = document.querySelector('#btnpost');
    buttonpost.addEventListener('mousedown', function() {
        const id_product_post  = "abc_post";
        const qty_product_post = "def_post";
        const url = "/objtestpost";
        const params = "id_product=" + id_product_post + "&qty_product=" + qty_product_post;
        sendRequest('POST', url, params);
    });

    // 2 POST - JSON
    const btnjson = document.querySelector('#btnjson');
    btnjson.addEventListener('mousedown', function() {
        const id_product_json  = "abc_JSON";
        const qty_product_json = "def_JSON";
        const url = "/objtestjson";
        const object = {
            "id_product": id_product_json,
            "qty_product": qty_product_json
        }
        sendRequest('JSON', url, object);
    });


function sendRequest(type, url, params) {
    const request = new XMLHttpRequest();
    request.addEventListener("readystatechange", function() {
        if (request.readyState === 4 && request.status === 200) {
            console.log(request.responseText);
        }
    });

    if (type === 'GET') {
        request.open('GET', url);
        request.setRequestHeader('Content-Type', 'application/x-www-form-url');
        request.send();
    } else if (type === 'POST') {
        request.open('POST', url);
        request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        request.send(params);
    } else if (type === 'JSON') {
        request.open("POST", url, true);
        request.setRequestHeader("Content-Type", "application/json");
        const data = JSON.stringify(params);
        request.send(data);
    }
}




}, false);
