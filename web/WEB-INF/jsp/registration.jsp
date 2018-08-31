<%@include  file="start.jsp" %>
    <!--Container za formu -->
    <div class="container my-form my-container my-container-width">
        <h2 id="form-header">Registracija</h2>
        <!--Forma -->
        <form:form action="../registration" method="post" modelAttribute="user" class="main-form">
            <!--Red za ime i prezime -->
                <div class="row">
                    <!-- Kolona za ime -->
                    <div class="col-lg-6 col-md-12">
                        <div class="form-group">  
                            <form:input path="firstName" type="text"  id="first-name" class="form-control my-input" placeholder="ime" />
                                <form:errors path="firstName" cssClass="errors"/>
                        </div>
                    </div>
                    <!-- Kolona za prezime -->
                    <div class="col col-lg-6 col-md-12">
                        <div class="form-group">    
                            <form:input type="text" path="lastName" id="last-name" class="form-control my-input" placeholder="prezime" />
                             <form:errors path="lastName" cssClass="errors"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                   
                    <form:input type="text" path="userName" id="username" class="form-control my-input" placeholder="korisnicko ime" />
                    <form:errors path="userName" cssClass="errors"/>
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
                </div>
                <div class="form-group">
                    <form:input type="date" path="dateOfBirth" id="date" class="form-control my-input" />
                      <form:errors path="dateOfBirth" cssClass="errors"/>
                </div>
                <div class="form-group">
                   
                    <select name="gender" id="gender" class="form-control my-input">
                        <option value="">izaberite pol</option>
                        <option value="male">Musko</option>
                        <option value="female">Zensko</option>
                    </select>
                </div>
             <div class="form-group">
                   
                    <select name="country" id="country" class="form-control my-input">
                        <option value="" selected>drzava </option>
                        <option value="srbija">Srbija</option>
                        <option value="nemacka">Nemacka</option>
                    </select>
                </div>
                 <div class="form-group">
                   
                    <select name="city" id="city" class="form-control my-input">
                        <option value="-1" selected>grad</option>
                        <option value="2">Male</option>
                        <option value="3">Female</option>
                    </select>
                </div>
                
                
                <button type="submit" class="btn btn-outline-info my-button" >Potvrdi</button>
            </form:form>
        </div>

<%@include file="end.jsp" %>