<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Mood of the month</title>

    <!-- Bootstrap CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="resources/css/style.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>

<body>
<div id="page-wrapper" class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Your MOTM</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-10 col-lg-offset-1">
                    <!-- /.panel -->
                    <div class="panel panel-default">
                        <div class="panel-body" id="add_motm">
                          <div class="row">
                              <div class="col-lg-12">
                                <h3>${motm_template}</h3>
                                <br/>

                              </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-12" >
                                    <form action="/projet/add_motm?member_id=1" method="post" class="">
                                        <div class="vote">
                                            <div class="mood">
                                                <div class="img-container">
                                                    <img src="resources/img/1.png" alt="super"/>
                                                 </div>
                                                 <div class="img-container">
                                                    <img src="resources/img/2.png" alt="super"/>
                                                 </div>
                                                 <div class="img-container">
                                                    <img src="resources/img/3.png" alt="super"/>
                                                 </div>
                                                 <div class="img-container">
                                                    <img src="resources/img/4.png" alt="super"/>
                                                 </div>
                                                 <div class="img-container">
                                                    <img src="resources/img/5.png" alt="super"/>
                                                 </div>
                                             </div>
                                         </div>
                                         <div class="form-group">
                                             <label for="motm" class="form-label">Your Mood this Month</label>
                                             <input type="range" class="form-range" min="1" max="5" step="1" id="motm" name="motm" value="${motm_old}">
                                         </div>
                                         <div class="form-group">
                                             <label for="comment">Your comment</label>
                                             </br>
                                             <input type="text" id="comment" name="comment" value="${comment_old}" class="input-lg form-control"></input>
                                         </div>
                                         <div class="form-check form-switch">
                                           <input class="form-check-input" type="checkbox" id="isPublic" name="isPublic" value="true">
                                           <label class="form-check-label" for="isPublic" >Public comment</label>
                                         </div>
                                         <div class="text-right">
                                             <button type="submit" class="btn btn-lg btn-primary">Save</button>
                                         </div>
                                     </form>
                                </div>
                            </div>
                            <!-- /.row -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
    </div>
    <!-- /#wrapper -->
    <footer class="footer">
        <div class="container">
            <div class="row text-center">
                Resourcepool &bullet; 2017
            </div>
        </div>
    </footer>

    <!-- jQuery -->
    <script src="resources/js/jquery-3.1.1.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="resources/js/bootstrap.min.js"></script>

</body>

</html>
