<%@include file="start.jsp" %>
<link href="<spring:url value="style/userprofile.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<%@include file="navbar.jsp"%>
<div class="container main-container">  
    <div class="row justify-content-start pt-5 pl-5  profile-content">
        <!-- Kolona za sliku-->
        <div class="col-sm-3 mr-5" >
            <div class="mb-5 profilna" >
                <img src="${user.getPicture()}" class="img-fluid mx-auto d-block">
                <label class="btn btn-default btn-file ml-3">
                    Promeni profilnu sliku  <i class="fa fa-camera-retro ml-1" style="font-size:22px"></i><input type="file" style="display: none;">
                </label>
            </div>
            <div class="mb-5">
                <h5 class="mb-3">Kratak opis o korisniku</h5>
                <p>${user.getBio()}</p>
            </div>
        </div>

        <!-- Kolona za sliku-->
        <div class="col-sm-7" >
            <div class="osnonve-info">
                <h3 id="ime">${user.getFirstName()} ${user.getLastName()}</h3>
            </div>
            <div class="zanimanje mb-5">
                <h5 class="">Java Developer</h5>
            </div>


            <!--tabs-->
            <!--nav  tabs -->
            <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" id="profil-tab" data-toggle="tab" href="#profil" role="tab" aria-controls="profil" aria-selected="true">Profil</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="aktivnosti-tab" data-toggle="tab" href="#aktivnosti" role="tab" aria-controls="aktivnosti" aria-selected="false">Aktivnosti</a>
                </li>

            </ul><!-- kraj nav tabs-->


            <!--nav tabs content-->
            <div class="tab-content" id="myTabContent">
                <!--Profil tab-->
                <div class="tab-pane fade show active pt-3" id="profil" role="tabpanel" aria-labelledby="profil-tab">
                    <!--kontakt info-->
                    <div class="container-fluid mb-5">
                        <span style="color: #bdc3c7;display: block;" class="mb-4">
                            kontakt informacije o korisniku</span>
                        <hr/>

                        <div class="row mb-3">
                            <div class="col-sm-4 mr-3">
                                Korisnicko ime:
                            </div>
                            <div class="col-sm-5">
                                ${user.getUserName()}
                            </div>
                        </div>

                        <div class="row mb-3">
                            <div class="col-sm-4 mr-3">
                                Adresa stanovanja:
                            </div>
                            <div class="col-sm-5">
                                ${user.getCity()},${user.getCountry()}
                            </div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-sm-4 mr-3">
                                Email adresa:
                            </div>
                            <div class="col-sm-5">
                                <a href="mailto:${user.getEmail()}">${user.getEmail()}</a>
                            </div>
                        </div>

                        <div class="row mb-3">
                            <div class="col-sm-4 mr-3">
                                Sajt:
                            </div>
                            <div class="col-sm-5">
                                <a href="#">www.BlogSpot.com</a>
                            </div>
                        </div>
                    </div>

                    <!--osnovne info-->
                    <div class="container-fluid mb-5">
                        <span style="color: #bdc3c7;display: block;" class="mb-4">
                            osnonve-info informacije o korisniku</span>
                        <hr/>

                        <div class="row mb-3">
                            <div class="col-sm-4 mr-3">
                                Datum rodjenja:
                            </div>
                            <div class="col-sm-5">
                                ${user.getDateOfBirth()}
                            </div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-sm-4 mr-3">
                                Pol:
                            </div>
                            <div class="col-sm-5">
                                ${user.getGender()}
                            </div>
                        </div>

                        <div class="row mb-3">
                            <div class="col-sm-4 mr-3">
                                Interesovanja:
                            </div>
                            <div class="col-sm-5">
                                <ul id="zanimanja">
                                    <li>Programiranje</li>
                                    <li>Web dizajn</li>
                                    <li>Gejming</li>
                                </ul>
                            </div>
                        </div>
                    </div>

                </div><!--kraj profil taba-->

                <!-- aktivnosti tab-->
                <div class="tab-pane fade pt-3" id="aktivnosti" role="tabpanel" aria-labelledby="aktivnosti-tab">
                    <div class="container-fluid mb-5">
                        <span style="color: #bdc3c7;display: block;" class="mb-4">
                            aktivnosti korisnika</span>
                        <hr/>
                    </div>

                </div><!--kraj aktivnosti taba-->


            </div><!--kraj nav tabs content-->
        </div>
    </div>
</div>
    <%@include file="end.jsp" %>