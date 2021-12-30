function loadHomeContent(){
    let html = `<div class="col-9" id="list-product"></div>
        <div class="col-3" id="category"></div>`;
    document.getElementById('content').innerHTML =html;
    loadListProduct();
    loadListClass();
}

function loadListProduct() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/posts",
        success: function (nal) {
            console.log(nal);
            let html = `<div class="row p-3">`;
            for (let i = 0; i < nal.length; i++) {
                html += '<div class="col-4 product p-3"><h2>' + nal[i].title +nal[i].content+ '</h2></div>'
            }
            html += `</div>`;
            document.getElementById('list-product').innerHTML = html;
        }
    })
}
    function loadListClass() {
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/api/modes",
            success: function (nal) {
                console.log(nal);
                let html = `<div class="row p-3">`;
                for (let i = 0; i < nal.length; i++) {
                    html += '<div class="col-12"><h5>' + nal[i].name + '</h5></div>'
                }
                html += `</div>`;
                document.getElementById('category').innerHTML = html;
            }
        })
    }

