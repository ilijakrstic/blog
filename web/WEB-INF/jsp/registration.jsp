<%@include  file="start.jsp" %>
<link href="<spring:url value="style/registration.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
    <%@include  file="navbar.jsp" %>
    <!--Container za formu -->
    <div class="container my-form my-container my-container-width my-container-padding my-container-margin">
        <h2 id="form-header">Registracija</h2>

        <!--Forma -->
        <form:form action="../registration" method="post" modelAttribute="user" class="main-form">
            <!--Red za ime i prezime -->
            <div class="row">
                <!-- Kolona za ime -->
                <div class="col-lg-6 col-xs-12">
                    <div class="form-group">  
                        <form:input path="firstName" type="text"  id="first-name" class="form-control my-input" placeholder="ime" />
                        <form:errors path="firstName" cssClass="errors"/>
                    </div>
                </div>
                <!-- Kolona za prezime -->
                <div class="col col-lg-6 col-xs-12">
                    <div class="form-group">    
                        <form:input type="text" path="lastName" id="last-name" class="form-control my-input" placeholder="prezime" />
                        <form:errors path="lastName" cssClass="errors"/>
                    </div>
                </div>
            </div>

            <div class="form-group">

                <form:input type="text" path="userName" id="username" class="form-control my-input" placeholder="korisnicko ime" />
                <form:errors path="userName" cssClass="errors"/>


                <c:if test = "${userNameExists!=null}">
                    <p class="errors"> ${userNameExists}<p>
                    </c:if>
            </div>
            <div class="form-group">

                <form:input type="password" path="password" id="password" class="form-control my-input"
                            placeholder="sifra" />
                <form:errors path="password" cssClass="errors"/>

            </div>
            <div class="form-group">
                <form:input type="email" path="email" id="email" class="form-control my-input"
                            placeholder="email adresa" />
                <form:errors path="email" cssClass="errors"/>
                <c:if test = "${emailExists!=null }">
                    <p class="errors"> ${emailExists}<p>
                    </c:if>
            </div>
            <div class="form-group">
                <form:input type="date" path="dateOfBirth" id="date" class="form-control my-input" />
                <form:errors path="dateOfBirth" cssClass="errors"/>
            </div>



            <!--Pol radio buttonsi -->

            <div class="form-group">              
                <form:select path="gender" id="gender" class="form-control my-input">
                    <form:option value="-1" label="izaberi pol"/>


                    <form:option value="MUSKO" label="M"/>
                    <form:option value="ZENSKO" label="Z"/>
                </form:select>
                <form:errors path="country" cssClass="errors"/>
            </div>

            <!-- Material unchecked -->


            <!-- Drop za drzave -->
            <div class="form-group">              
                <form:input id="grad_drzava" type="text" path="country" placeholder="grad/drzava" class="form-control my-input"/>
            </div>



            <div class="form-group">

                <form:textarea path="bio" id="bio" class="form-control my-input" placeholder="nesto kratko o sebi" rows="7"></form:textarea>
                <form:errors path="bio" cssClass="errors"/>
            </div>

            <button type="submit" class="btn btn-outline-success my-button" >Potvrdi</button>

        </form:form>
    </div>

    <script>
        function activatePlacesSearch() {
            var input = document.getElementById('grad_drzava');
            var autocomplete = new google.maps.places.Autocomplete(input);

        }
    </script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCYY5kf8MqLSCP6KYASQ08p2zUHb4YS_Yw&libraries=places&callback=activatePlacesSearch"></script>


    <%@include file="end.jsp" %>