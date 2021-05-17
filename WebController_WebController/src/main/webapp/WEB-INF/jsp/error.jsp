<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE>
<html lang="en">
<head>
    <title>Home</title>
    <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@600;900&display=swap" rel="stylesheet">
  <script src="https://kit.fontawesome.com/4b9ba14b0f.js" crossorigin="anonymous"></script>
    
<style>

body {
  background-color: #95c2de;
}

.mainbox {
  background-color: #95c2de;
  margin: auto;
  height: 600px;
  width: 600px;
  position: relative;
}

  .err {
    color: #ffffff;
    font-family: 'Nunito Sans', sans-serif;
    font-size: 11rem;
    position:absolute;
    left: 20%;
    top: 8%;
  }

.far {
  position: absolute;
  font-size: 8.5rem;
  left: 42%;
  top: 15%;
  color: #ffffff;
}

 .err2 {
    color: #ffffff;
    font-family: 'Nunito Sans', sans-serif;
    font-size: 11rem;
    position:absolute;
    left: 68%;
    top: 8%;
  }

.msg {
    text-align: center;
    font-family: 'Nunito Sans', sans-serif;
    font-size: 1.6rem;
    position:absolute;
    left: 16%;
    top: 45%;
    width: 75%;
  }

a {
  text-decoration: none;
  color: white;
}

a:hover {
  text-decoration: underline;
}
  
    
    
</style>
</head>
<body>
<div class="mainbox">    
    <div class="msg"><span>${errorMsg } : ${code}</span>
            <p>Let's go 
                <form action="/home">
                <button type="button float-right" style="margin-right: 10px;"
                    class="btn btn-outline-light"><h2>Home</h2>
                </button>
                </form> and try from there.
        </p></div>
      </div>
    
    
</body>
</html>
               