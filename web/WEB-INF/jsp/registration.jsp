<%@include  file="start.jsp" %>
<!--Container za formu -->
<div class="container my-form my-container my-container-width my-container-padding">
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



        <!--Pol radio buttonsi -->
        <div class="form-group">

            <div class="form-check-inline">
                <label class="form-check-label" for="radio1">
                    <form:radiobutton path="gender" value="M"/>Musko 
                   
                </label>
            </div>
            <div class="form-check-inline">
                <label class="form-check-label" for="radio2">
                     <form:radiobutton path="gender" value="Z"/>Zensko
                </label>
            </div>
        </div>

        <!-- Drop za drzave -->
        <div class="form-group">              
            <form:select path="country" id="country" class="form-control my-input">
                <form:option value="-1" label="izaberi drzavu"/>

                <c:forEach items="${countries}"  var="c">
                    <form:option value="${c.getCountryName()}" label="${c.getCountryName()}"/>
                </c:forEach>
            </form:select>
            <form:errors path="country" cssClass="errors"/>
        </div>


        <!-- Input za grad-->
        <div class="form-group">

            <form:input type="text" path="city" id="city" class="form-control my-input" placeholder="grad" />
            <form:errors path="city" cssClass="errors"/>
        </div>
        <div class="form-group">

            <form:textarea path="bio" id="bio" class="form-control my-input" placeholder="nesto malo o sebi" rows="10"></form:textarea>
            <form:errors path="bio" cssClass="errors"/>
        </div>

        <button type="submit" class="btn btn-outline-info my-button" >Potvrdi</button>
    </form:form>
</div>

<%@include file="end.jsp" %>