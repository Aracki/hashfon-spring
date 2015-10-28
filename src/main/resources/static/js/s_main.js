$('#logIn').click(function () {
    logIn();
});

$('#sacuvajButton').click(function () {

    var emailUpdate = $('#emailUpdate').val();
    var loz1 = $('#lozinka1').val();
    var loz2 = $('#lozinka2').val();
    var fon = $('#fonn').val();

    if (loz1 !== loz2) {
        return;
    }

    var string = {
        email: emailUpdate,
        password: loz2,
        godinaDiplomiranja: $('#godinaDiplomiranja').val(),
        dodatneInformacije: $('#dodatneInformacije').val(),
        adresa: $('#adresaUpdate').val(),
        telefon: fon,
        slika: ' ',
        id: 1
    };

    var jsonObj = JSON.stringify(string);

    $.ajax({
        url: 'http://localhost:8080/api/resources/student',
        dataType: 'json',
        method: 'PUT',
        data: jsonObj,
        headers: {
            'Content-Type': 'application/json',
            'Authorization': getCookie('token')
        },
        success: function (response) {
            alert('Uspesno editovan student!');
            window.close();
            location.reload();
        },
        error: function (response) {
            alert('Greska');
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
            }

        });
    }
});

$('#post_dugme').click(function () {
    var t = $('#tagovi').val();
    var snp = $('#kod').val();

    var string = {
        code: snp,
        hash: {
            tag: t
        }
    };

    var json = JSON.stringify(string);
    alert(json);
    $.ajax({
        url: 'http://localhost:8080/api/resources/snippet',
        dataType: 'json',
        method: 'POST',
        data: json,
        headers: {
            'Content-Type': 'application/json',
            'Authorization': getCookie('token')
        },
        success: function (response) {
            location.reload();
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
    //var par = oglas.substring(1);
    $.ajax({
        url: 'http://localhost:8080/api/resources/oglasKompanije/search/getOglasKompanije?search=' + oglas,
        dataType: 'json',
        success: function (response) {
            napuniSidebarKompanije(response);
        },
        headers: {
            'Content-Type': 'application/json',
            'Authorization': getCookie('token')
        },
    });

});

$(function () {
    $(document).on('click', '[id^=XX]', function () {

        var id = jQuery(this).attr("id");
        var niz = id.split('XX');
        var id1 = niz[1];

        var r = confirm("Da li si siguran/a?");
        if (r === true) {

            $.ajax({
                url: 'http://localhost:8080/api/resources/snippet/' + id1,
                //dataType: 'json',
                method: 'delete',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': getCookie('token')
                },
                success: function (response) {
                    alert("Uspesno obrisan snippet!");
                    location.reload();
                }
            });

        }
        location.reload();
    });
});

$('[id^="XXX"]').each(function () {
});

function napuniSidebarKompanije(kompanije) {
    var lista = document.getElementById('lg-menu');
    lista.innerHTML = '';
    for (var o in kompanije) {
        var li = document.createElement('li');
        // li.addClass('xx');
        var a = document.createElement('a');
        a.href = "s_kompanija_profil?name=" + kompanije[o].id;
        a.innerHTML = kompanije[o].ime;

        li.appendChild(a);
        lista.appendChild(li);

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
        var li = document.createElement('li');
        var a = document.createElement('a');
        a.href = "kompanija.html?name=" + kompanije[k].id;
        a.innerHTML = kompanije[k].ime;

        li.appendChild(a);
        lista.appendChild(li);

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
}


function vratiKompaniju() {

    var sPageURL = decodeURIComponent(window.location.search.substring(1));
    var str = sPageURL.split('=');
    var idK = str[1];

    $.ajax({
        url: 'http://localhost:8080/api/resources/kompanija/search/getById?id=' + idK,
        dataType: 'json',
        success: function (response) {
            napuniKompaniju(response);
            napuniOglase(response.id);
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
}

function napuniOglase(id) {
    $.ajax({
        url: 'http://localhost:8080/api/resources/oglasKompanije/search/getByIdKompanije?idKompanije=' + id,
        dataType: 'json',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': getCookie('token')
        },

        success: function (response) {


            var oglasi = response;
            var oglasihtml = "";
            for (var i = 0; i < oglasi.length; i++) {
                oglasihtml += '<div class="panel panel-default">' + '<div class="panel-heading">' + '' + oglasi[i].naziv + '</h4>' + '</div>' + '<div class="panel-body">' + '	<p id="code"> ' + oglasi[i].oglas + ' </p>' + '</div>' + '<div class="clearfix"></div>' + '</div>';
            }
            $('#rowOglasi').html(oglasihtml);
        }
    });
}



function napuniVestiOglasa() {
    $.ajax({
        url: 'http://localhost:8080/api/resources/oglasKompanije',
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

//napuni profil studenta
function napuniProfil() {
    var idStudenta = location.search.split('id=')[1];
    alert(idStudenta);
    $.ajax({
        url: 'http://localhost:8080/api/resources/student/search/getById?id=' + idStudenta,
        dataType: 'json',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': getCookie('token')
        },
        success: function (response) {
            alert(response);
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

function napuniProfilStudenta() {
    var idStudenta = 1;
    $.ajax({
        url: 'http://localhost:8080/api/resources/student/search/getById?id=' + idStudenta,
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

function napuniSnipeteStudenta() {
    var id = 1;
    $.ajax({
        url: 'http://localhost:8080/api/resources/snippet/search/getByIdStudent?idStudent=' + id,
        dataType: 'json',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': getCookie('token')
        },

        success: function (response) {


            var snipeti = response;
            var snipethtml = "";
            for (var i = 0; i < snipeti.length; i++) {
                var idSnipet = snipeti[i].snippetPk.id;
                snipethtml += '<div class="panel panel-default">' + '<div class="panel-heading">' + '<button class="btn btn-danger" id="XX' + idSnipet + '"' + ' <h4></a>' + snipeti[i].hash.tag + '</h4>' + '</div>' + '<div class="panel-body">' + '	<p id="code"> ' + snipeti[i].code + ' </p>' + '<div class="clearfix"></div>' + '<hr>' + snipeti[i].student.ime + ' ' + snipeti[i].student.prezime + '</div>' + '</div>';
            }
            $('#rowSnipeti').html(snipethtml);
        }
    });
}

$(document).ready(function () {
    // searchKompanije();
    napuniVestiOglasa();

});

