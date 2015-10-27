$('#logIn').click(function () {
    logIn();
});

$('#sacuvajButton').click(function () {

    var loz1 = $('#lozinka1').val();
    var loz2 = $('#lozinka2').val();
    var fon = $('#fonn').val();

    if (loz1 !== loz2) {
        return;
    }

    var string = {
        email: loz1,
        password: loz2,
        godinaDiplomiranja: $('#godinaDiplomiranja').val(),
        dodatneInformacije: $('#dodatneInformacije').val(),
        adresa: $('#adresaUpdate').val(),
        telefon: fon,
        slika: ' '
    };

    var jsonObj = JSON.stringify(string);

    $.ajax({
        url: 'http://192.168.186.52:8080/hashfon/rest/student',
        dataType: 'json',
        method: 'PUT',
        data: jsonObj,
        headers: {
            'Content-Type': 'application/json',
            'Authorization': getCookie('token')
        },
        success: function (response) {
            alert('Uspesno ste editovali studenta!');
            refreshInfo();
        },
        error: function (response) {
            alert('Uspesno ste editovali studenta');
            refreshInfo();
            this.close();
        }

    });
});


$('#logOut').click(function () {
    var r = confirm("Da li si siguran/a?");
    if (r === true) {
        $.ajax({
            url: 'http://192.168.186.52:8080/hashfon/rest/loging/logout',
            // dataType: 'json',
            method: 'POST',
            headers: {
                // 'Content-Type': 'application/json',
                'Authorization': getCookie('token')
            },
            success: function (response) {
                document.cookie = 'token' + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT; path=/hashfon";


                window.location.href = "../index.html";
                // alert(getCookie('token'));
            }

        });
    }
});

$('#post_dugme').click(function () {
    var t = $('#tagovi').val();
    var snp = $('#kod').val();

    var string = {
        code: snp,
        idHash: {
            tag: t
        }
    };

    var json = JSON.stringify(string);
    alert(json);
    $.ajax({
        url: 'http://192.168.186.52:8080/hashfon/rest/snipet',
        dataType: 'json',
        method: 'POST',
        data: json,
        headers: {
            'Content-Type': 'application/json',
            'Authorization': getCookie('token')
        },
        success: function (response) {
            alert(response);
        }

    });


});

function refreshInfo() {
    napuniProfil();
    var id = 0;
    id = window.setInterval(napuniProfil, 100);
    window.clearInterval(id);


}

$('#srch').click(function () {
    var oglas = $('#srch-term').val();
    // par = par.substring(1);
    $.ajax({
        url: 'http://192.168.186.52:8080/hashfon/rest/oglasi?search=' + oglas,
        dataType: 'json',
        success: function (response) {
            // alert(JSON.stringify(response));
            // $('.xx').remove();
            napuniSidebarKompanije(response);
        },
        headers: {
            'Content-Type': 'application/json',
            'Authorization': getCookie('token')
        },
    });

});

function napuniSidebarKompanije(kompanije) {
    var lista = document.getElementById('lg-menu');
    lista.innerHTML = '';
    for (var o in kompanije) {

        // alert();
        var li = document.createElement('li');
        // li.addClass('xx');
        var a = document.createElement('a');
        a.href = "kompanija.html?name=" + kompanije[o].id;
        a.innerHTML = kompanije[o].ime;

        // li.innerHTML = kompanije[k].ime;

        li.appendChild(a);
        lista.appendChild(li);
        // lista.append('<li><a href="sdasad.com"></a></li>')

    }


}

var json_token;
var kolac = document.cookie;
var studenti;

function make_base_auth(user, password) {
    var tok = user + ':' + password;
    var hash = btoa(tok);
    return "Basic " + hash;
}

function logIn() {
    var username = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    $.ajax({
        type: "POST",
        url: "http://192.168.186.52:8080/hashfon/rest/loging/login",
        dataType: "json",
        headers: {
            'Content-Type': 'application/json'
        },
        beforeSend: function (xhr) {
            xhr.setRequestHeader('Authorization', make_base_auth(username, password));
        },
        success: function (response) {

        },
        async: false,

        error: function (response) {
            alert("Niste se uspesno ulogovali!");
        }

    });
}


var kompanije;

function napuniSideBar() {

    var lista = document.getElementById('lg-menu');
    for (var k in kompanije) {
        // alert();
        var li = document.createElement('li');
        var a = document.createElement('a');
        a.href = "kompanija.html?name=" + kompanije[k].id;
        a.innerHTML = kompanije[k].ime;

        // li.innerHTML = kompanije[k].ime;

        li.appendChild(a);
        lista.appendChild(li);
        // lista.append('<li><a href="sdasad.com"></a></li>')

    }
}


function searchKompanije() {
    $.ajax({
        url: 'http://192.168.186.52:8080/hashfon/rest/kompanija',
        dataType: 'json',
        success: function (response) {
            kompanije = response;
            napuniSideBar();
        },
        beforeSend: function (xhr) {
            xhr.setRequestHeader('Authorization', getCookie('token'));
        },
    });

    // $.getJSON('http://192.168.186.52:8080/hashfon/rest/kompanija',  function(json, textStatus) {
    //     /*optional stuff to do after success */
    //     alert(json);
    // });
}


function vratiKompaniju() {

    var sPageURL = decodeURIComponent(window.location.search.substring(1));
    var str = sPageURL.split('=');
    var idK = str[1];

    $.ajax({
        url: 'http://192.168.186.52:8080/hashfon/rest/kompanija/' + idK,
        dataType: 'json',
        success: function (response) {
            napuniKompaniju(response);
        },
        beforeSend: function (xhr) {
            xhr.setRequestHeader('Authorization', getCookie('token'));
        }
    });
}


function napuniKompaniju(k) {
    $('#ime').html(k.ime);
    $('#email').html(k.email);
    $('#adresa').html(k.adresa);
    $('#miniNaslov').html(k.opis);
    // $('#ime').html(k.ime);

}

function napuniVestiOglasa() {
    $.ajax({
        url: 'http://192.168.186.52:8080/hashfon/rest/oglasi',
        dataType: 'json',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': getCookie('token')
        },
        success: function (response) {
            var oglasi = response;
            var oglashtml = "";
            for (var i = 0; i < oglasi.length; i++) {

                oglashtml += '<div class="panel panel-default">' + '<div class="panel-heading">' + '<a href="kompanija.html?name="' + oglasi[i].kompanija.id + ' <h4></a>' + oglasi[i].naziv + '</h4>' + '</div>' + '<div class="panel-body">' + '	<p> ' + oglasi[i].oglas + ' </p>' + '<div class="clearfix"></div>' + '<hr>' + oglasi[i].kompanija.ime + '</div>' + '</div>';
                // $('#ime_prezime').innerHTML = snipeti[i].student;
            }
            $('#rowOglasi').html(oglashtml);
        }
    });


}

function napuniSnipete() {
    $.ajax({
        url: 'http://192.168.186.52:8080/hashfon/rest/snipet/ja',
        dataType: 'json',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': getCookie('token')
        },

        success: function (response) {
            var snipeti = response;
            var snipethtml = "";
            for (var i = 0; i < snipeti.length; i++) {
                snipethtml += '<div class="panel panel-default">' + '<div class="panel-heading">' + '' + snipeti[i].idHash.tag + '</h4>' + '</div>' + '<div class="panel-body">' + '	<p id="code"> ' + snipeti[i].code + ' </p>' + '<div class="clearfix"></div>' + '<hr>' + snipeti[i].student.ime + ' ' + snipeti[i].student.prezime + '</div>' + '</div>';
            }
            // alert(snipethtml);
            $('#rowSnipeti').html(snipethtml);
        }
    });
}


function napuniProfil() {
    // alert(getCookie('token'));
    $.ajax({
        url: 'http://192.168.186.52:8080/hashfon/rest/student/ja',
        dataType: 'json',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': getCookie('token')
        },
        success: function (response) {
            var date = new Date(response.datumRodjenja);
            var d = date.getUTCDate() + 1;
            var m = date.getUTCMonth() + 1;
            var y = date.getFullYear();
            $('#ime').html(response.ime + ' ' + response.prezime);
            $('#email').html(response.email);
            $('#fon').html(response.telefon);
            $('#adresa').html(response.adresa);
            $('#comment').html(response.dodatneInformacije);
            $('#godD').html('Godina diplomiranja : ' + response.godinaDiplomiranja);

            $('#datumR').html('Datum rodjenja : ' + d + "." + m + "." + y + ".");

        }
    });
}

$(document).ready(function () {
    // searchKompanije();
    napuniVestiOglasa();

});