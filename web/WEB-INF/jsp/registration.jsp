<!DOCTYPE html>
<html lang="en">
<head>
    <base href="../resource/"/> <!-- Stavio sam base na resources pa da posle nekucam  celu putanju za svaki el pa mozda u nb pravi problem pa vidi ak nece-->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Starter Template Bootstrap</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="style/registration.css">
</head>
<body>
    
    <!--Container za formu -->
    <div class="container my-form my-container my-container-width">
        <h2 id="form-header">Registracija</h2>
        <!--Forma -->
        <form action="" class="main-form needs-validation " novalidate>
            <!--Red za ime i prezime -->
                <div class="row">
                    <!-- Kolona za ime -->
                    <div class="col-lg-6 col-md-12">
                        <div class="form-group">
                            
                            <input type="text" name="first-name" id="first-name" class="form-control my-input" placeholder="ime"  required>
                            <div class="invalid-feedback">User name not valid!</div>

                        </div>
                    </div>
                    <!-- Kolona za prezime -->
                    <div class="col col-lg-6 col-md-12">
                        <div class="form-group">
                           
                            <input type="password" name="last-name" id="last-name" class="form-control my-input" placeholder="prezime">
                            
                        </div>
                    </div>
                </div>



                <div class="form-group">
                   
                    <input type="text" name="username" id="username" class="form-control my-input" placeholder="korisnicko ime">
                    <div class="valid-feedback">Looks good!</div>
                </div>
                <div class="form-group">
                   
                    <input type="password" name="password" id="password" class="form-control my-input"
                    placeholder="sifra" required>
                    <div class="invalid-feedback">Please enter valid password</div>
                </div>
                <div class="form-group">
                    <input type="email" name="email" id="email" class="form-control my-input"
                    placeholder="email adresa" required>
                    <div class="invalid-feedback">Please enter valid email</div>
                </div>
                <div class="form-group">
                    <input type="date" name="date" id="date" class="form-control my-input"
                     required>
                    <div class="invalid-feedback">Please enter valid email</div>
                </div>
                <div class="form-group">
                   
                    <select name="gender" id="gender" class="form-control my-input">
                        <option value="0">izaberite pol</option>
                        <option value="male">Musko</option>
                        <option value="female">Zensko</option>
                    </select>
                </div>
             <div class="form-group">
                   
                    <select name="country" id="country" class="form-control my-input">
                        <option value="0" selected>drzava </option>
                        <option value="srbija">Srbija</option>
                        <option value="nemacka">Nemacka</option>
                    </select>
                </div>
                 <div class="form-group">
                   
                    <select name="city" id="city" class="form-control my-input">
                        <option value="1" selected>grad</option>
                        <option value="2">Male</option>
                        <option value="3">Female</option>
                    </select>
                </div>
                
                
                <button type="submit" class="btn btn-outline-info my-button" >Potvrdi</button>
            </form>
        </div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>