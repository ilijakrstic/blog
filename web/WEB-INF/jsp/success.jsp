<%@include file="start.jsp" %>

<h1>${user.getUserName()}</h1>
<h1>${user.getFirstName()}</h1>
<h1>${user.getLastName()}</h1>
<h1>${user.getPassword()}</h1>
<h1>${user.getEmail()}</h1>
<h1>${user.getDateOfBirth()}</h1>
<h1>${user.getBio()}</h1>
<h1>${user.getCity()}</h1>
<h1>${user.getCountry()}</h1>
<h1>${user.getGender()}</h1>
<%@include file="end.jsp" %>