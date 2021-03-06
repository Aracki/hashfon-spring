// alert(json_token);
var stid;

$('#logIn').click(function () {
    logIn();
});

$('#objavi_dugme').click(function () {

    var naz = $('#naziv').val();
    var ogl = $('#oglas').val();
    var string = {
        naziv: naz,
        oglas: ogl,
        oglasKompanijePk: {
            idKompanije: 2
        }
    };

    var json = JSON.stringify(string);

    $.ajax({
        url: 'http://localhost:8080/api/resources/oglasKompanije',
        dataType: 'json',
        method: 'POST',
        data: json,
        headers: {
            'Content-Type': 'application/json',
            'Authorization': getCookie('token')
        },
        success: function (response) {
            alert("Uspesan insert!");
            refreshOglase();
        }
    });
    refreshOglase();
});

function refreshOglase() {
    napuniOglaseInfo();
    var id = 0;
    id = window.setInterval(napuniOglaseInfo, 100);
    window.clearInterval(id);
}

$('#srch').click(function () {
    var par = $('#srch-term').val();
    par = par.substring(1);
    $.ajax({
        url: 'http://localhost:8080/api/resources/student/search/getByTagName?search=' + par,
        dataType: 'json',
        success: function (response) {
            napuniSideBarKompanija(response);
        },
        headers: {
            'Content-Type': 'application/json',
            'Authorization': getCookie('token')
        },
    });

});

// var json_token;
var emailtoken;
var username;
var studenti;
var studenti1;

function make_base_auth(user, password) {
    var tok = user + ':' + password;
    var hash = btoa(tok);
    return "Basic " + hash;
}

function logIn() {
    username = document.getElementById("email").value;
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
            // napuniToken(response.token);
            // document.cookie="getCookie('token')=" + getCookie('token');
            json_token = response.token;
            setCookie('token', json_token, 1);


            if (response.klijent == "kompanija") {
                location.href = "projekat_hashfon_kompanija/k_pocetna.html";
            } else {
                location.href = "projekat_hashfon_student/k_pocetna.html";
            }
            // return response.token;
        },
        async: false,

        error: function (response) {
            alert("Niste se uspesno ulogovali!");
        }

    });
}

function napuniSideBarKompanija(objekti) {

    var lista = document.getElementById('lg-menu');
    for (var s in objekti) {
        // alert();
        var li = document.createElement('li');
        var a = document.createElement('a');
        a.href = "k_student_profil?id=" + objekti[s].id;
        a.innerHTML = objekti[s].ime + " " + objekti[s].prezime;

        // li.innerHTML = kompanije[k].ime;

        li.appendChild(a);
        lista.appendChild(li);
        // lista.append('<li><a href="sdasad.com"></a></li>')

    }
}

function searchStudenta() {
    $.ajax({
        url: 'http://192.168.186.52:8080/hashfon/rest/student',
        dataType: 'json',
        success: function (response) {
            studenti1 = response;
            napuniSideBarKompanija();
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

function vratiStudenta() {

    var sPageURL = decodeURIComponent(window.location.search.substring(1));
    var str = sPageURL.split('=');
    var idK = str[1];

    $.ajax({
        url: 'http://localhost:8080/api/resources/student/search/getById?id=' + idK,
        dataType: 'json',
        success: function (response) {
            stid = idK;
            napuniStudenta(response);
            napuniSnipete(response.id);
        },
        beforeSend: function (xhr) {
            xhr.setRequestHeader('Authorization', getCookie('token'));
        }
    });
}

function napuniStudenta(s) {
    $('#imeprezime').html(s.ime + " " + s.prezime);
    $('#ime').html(s.ime);
    $('#prezime').html(s.prezime);
    var date = new Date(s.datumRodjenja);

    var d = date.getUTCDate() + 1;
    var m = date.getUTCMonth() + 1;
    var y = date.getFullYear();

    $('#email').html(s.email);
    $('#telefon').html(s.telefon);
    $('#adresa').html(s.adresa);
    $('#dodatne_informacije').html(s.dodatneInformacije);
    $('#datum_rodjenja').html(d + "." + m + "." + y + ".");
    // $('#ime').html(k.ime); SLIKAAAA

}


function getData() {
    $.ajax({
        url: 'http://192.168.186.52:8080/hashfon/rest/student',
        dataType: 'json',
        success: function (response) {
            studenti = response;
            napuniInfo();


        }
    });


}

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

function napuniInfoK() {
    $.ajax({
        url: 'http://localhost:8080/api/resources/kompanija/search/getById?id=' + 2,
        dataType: 'json',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': getCookie('token')
        },
        success: function (response) {
            $('#imeKomp').html(response.ime);
            $('#emailk').html(response.email);
            $('#adresak').html(response.adresa);
            $('#opisk').html(response.opis).prop("readonly", "readonly");
        }
    });
}

function napuniOglaseInfo() {
    $.ajax({
        url: 'http://localhost:8080/api/resources/oglasKompanije/search/getByIdKompanije?idKompanije= ' + 2,
        dataType: 'json',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': getCookie('token')
        },
        success: function (response) {
            var oglasi = response;
            var oglashtml = "";
            for (var i = 0; i < oglasi.length; i++) {
                var idoglas = oglasi[i].oglasKompanijePk.id;
                oglashtml +=
                    '<div class="panel panel-default">' +
                    '<div class="panel-heading">' +
                    '<h3>Ime oglasa: </h3>' +
                    '<h4>' + oglasi[i].naziv + '</h4>' +
                    '</div>' +
                    '<div class="panel-body">' + '	<p> '
                    + oglasi[i].oglas + ' </p>' + '<div class="clearfix"></div>' + '<hr>'
                    + oglasi[i].kompanija.ime +
                    '<button style="float:right;" class="btn btn-danger" id="XXX' + idoglas + '">Obrisi oglas</button> ' +
                    '</div>' +
                    '</div>';
            }
            $('#rowOglasi').html(oglashtml);
        }
    });
}

$(function () {
    $(document).on('click', '[id^=XXX]', function () {

        var id = jQuery(this).attr("id");
        var niz = id.split('XXX');
        var id1 = niz[1];

        var r = confirm("Da li si siguran/a?");
        if (r === true) {
            $.ajax({
                url: 'http://localhost:8080/api/resources/oglasKompanije/' + id1,
                method: 'delete',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': getCookie('token')
                },
                success: function (response) {
                    alert("Uspesno obrisan oglas!");
                    refreshOglase();
                }
            });
        }
        refreshOglase();
    });
});

$('[id^="XXX"]').each(function () {
    alert('msg');
});

function napuniInfo() {
    // alert(emailtoken);
    for (var i = 0; i < studenti.length; i++) {
        if (studenti[i].email == emailtoken) {
            trenutniUser = studenti[i].email;
            // alert(trenutniUser.prezime);
        }
    }
}

function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    var expires = "expires=" + d.toUTCString();
    document.cookie = cname + "=" + cvalue + "; " + expires;
}

function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') c = c.substring(1);
        if (c.indexOf(name) === 0) return c.substring(name.length, c.length);
    }
    return "";
}

function napuniPocetnuKompanija() {
    $.ajax({
        url: 'http://localhost:8080/api/resources/snippet',
        dataType: 'json',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': getCookie('token')
        },

        success: function (response) {
            var snipeti = response;
            var snipethtml = "";
            for (var i = 0; i < snipeti.length; i++) {

                snipethtml += '<div class="panel panel-default">' + '<div class="panel-heading">' + '<a href="k_student_profil.html?name="' + snipeti[i].student.id + ' <h4 id="ime_prezime"></a>' + snipeti[i].student.ime + ' ' + snipeti[i].student.prezime + '</h4>' + '</div>' + '<div class="panel-body">' + '	<p id="snipet"> ' + snipeti[i].code + ' </p>' + '<div class="clearfix"></div>' + '<hr> #' + snipeti[i].hash.tag + '</div>' + '</div>';
                // $('#ime_prezime').innerHTML = snipeti[i].student;
            }
            $('#redSnipeta').html(snipethtml);
        }
    });
}


function napuniSnipete(id) {
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
                snipethtml += '<div class="panel panel-default">' + '<div class="panel-heading">' + '' + snipeti[i].hash.tag + '</h4>' + '</div>' + '<div class="panel-body">' + '	<p id="code"> ' + snipeti[i].code + ' </p>' + '<div class="clearfix"></div>' + '<hr>' + snipeti[i].student.ime + ' ' + snipeti[i].student.prezime + '</div>' + '</div>';
            }
            $('#rowSnipeti').html(snipethtml);
        }
    });
}

$('#updateKompanija').click(function () {

    var jsonObj = {
        email: $('#emailUpdate').val(),
        adresa: $('#adresaUpdate').val(),
        opis: $('#opis').val(),
        id: 2
    };

    var jsonText = JSON.stringify(jsonObj);

    $.ajax({
        url: 'http://localhost:8080/api/resources/kompanija',
        dataType: 'json',
        method: 'PUT',
        data: jsonText,
        headers: {
            'Content-Type': 'application/json',
            'Authorization': getCookie('token')
        },
        success: function (response) {
            alert('Uspesno ste editovali kompaniju!');
            this.close();
            //refreshInfo();
        },
        error: function (response) {
            alert('Greska > ' + response);
            //refreshInfo();
            this.close();
        }

    });
});


$(document).ready(function () {


});
