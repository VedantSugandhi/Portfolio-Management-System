<!DOCTYPE HTML>
<HTML lang="en">
    <head>
    <title>Portfolio Manager</title>
        
      <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"> 
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
        
        
    <style>
             .material-icons {
            vertical-align: middle;
                }
            .navbar{
                background-color: black;
            }
           .footer {
       position: fixed;
       left: 0;
       bottom: 0;
       width: 100%;
       background-color: black;
       color: white;

    }
            .btn-primary,
            .btn-primary:hover,
            .btn-primary:active,
            .btn-primary:visited,
            .btn-primary:focus {
            background-color: black;
            border-color: black;
                }

            .headimag {
      width: 100%;
      height: 300px;

    }
            div#form-box {
      margin-top: -250px;


    }



    body {
        color: #fff;
        background: black;
    }

    </style>
        
    </head>
        
        <body>
            
                <nav class="navbar navbar-expand-lg navbar-dark">
                        <img src="https://image.flaticon.com/icons/png/128/3135/3135679.png" width="30" height="30" class="d-inline-block align-top" alt="">

                            <a class="navbar-brand">Portfolio Manager</a>
                                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#gg">
                                    <span class="navbar-toggler-icon"></span>
                                    </button>


                            <div class="collapse navbar-collapse" id="gg">
                            <ul class="navbar-nav ml-auto">
                            <li class="navbar-item active">
                                <form action="/logout" method="GET">
                                    <button type="button float-right" class="btn btn-outline-light">Logout</button> 
                                </form> 
                            </li>
                            </ul>
                            </div>

                </nav>

            
            
               <form>
                 <img alt="back" class="headimag" src="https://media.istockphoto.com/vectors/bull-vs-bear-origami-vector-id514753795?k=6&m=514753795&s=612x612&w=0&h=f3mcvb-7nulRwvdX25IZKg77eKsvtM_DWxAJeK4YdZA=" />
                <div class="container-fluid">

                <div class="row">
                  <div class="col-md-12">
                    <div id="form-box">
                    </div>
                    </div>
                    </div>
                    
                </div>
                </form>


            <div class="container-fluid mt-3">         
            <div class="row">


                 <div class="container-fluid mt-3">         
            <div class="row">
                <div class="col-md-6 col-sm-12">
                    <div class="card shadow-sm">
                        <img src="https://wallpapercave.com/wp/wp2800110.jpg"
                            class="d-block w-100" alt="Calculate" height="225" width="200">
                        <div class="card-body">
                            <p style="color:black;">Click below to view your total portfolio networth.</p>

                                <div class="text-center">
                                    
                                    <form action="/calculate-networth" method="GET"><button type="submit" value="submit" class="btn btn-outline-success">Calculate Networth</button>
                                    </form>
                                    
                                </div>
                        </div>
                    </div>
                </div>


                 <div class="col-md-6 col-sm-12">
                    <div class="card shadow-sm">
                        <img alt="home" src="https://besthqwallpapers.com/Uploads/30-11-2017/31211/thumb2-bitcoin-4k-electronic-money-crypto-currency-golden-coins.jpg"
                            class="d-block w-100" alt="sell" height="225" width="200">
                        <div class="card-body">
                            <p style="color:black;">Click below to sell your assets.</p>


                                <div class="text-center">
                                    <form action="/sell-assets" method="GET"><button type="submit" name="submit" class="btn btn-outline-danger">Sell Stock</button>
                                    </form>
                                </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
            </div>
            </div>
    

    </body>
</HTML>