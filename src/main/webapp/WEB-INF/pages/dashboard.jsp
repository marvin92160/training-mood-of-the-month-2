<%@ taglib prefix="c" uri="jakarta.tags.core" %>
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
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"
          type="text/css">
</head>

<body>

<div class="container-fluid" id="dashboard">

    <div class="half">
        <div class="month">
            <p class="title">${month} ${year}</p>
            <p class="subtitle">MOOD OF THE MONTH</p>
        </div>

        <div class="details">
            <div class="mood">
                <div class="img-container">
                    <img src="resources/img/1.png" alt="super"/>
                </div>
                <div class="progress-bar-container">
                    <span class="desc">Vote count: ${repartition[0]}</span>
                    <div class="progress">
                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="10"
                             aria-valuemin="0" aria-valuemax="100" style="width:${repartition[0]/count * 100}%">
                            <span class="">${repartition[0]/count * 100}%</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="mood">
                <div class="img-container">
                    <img src="resources/img/2.png" alt="super"/>
                </div>
                <div class="progress-bar-container">
                    <span class="desc">Vote count: ${repartition[1]}</span>
                    <div class="progress">
                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="5"
                             aria-valuemin="0" aria-valuemax="100" style="width:${repartition[1]/count * 100}%">
                            <span class="">${repartition[1]/count * 100}%</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="mood">
                <div class="img-container">
                    <img src="resources/img/3.png" alt="super"/>
                </div>
                <div class="progress-bar-container">
                    <span class="desc">Vote count: ${repartition[2]}</span>
                    <div class="progress">
                        <div class="progress-bar progress-bar-neutral" role="progressbar" aria-valuenow="15"
                             aria-valuemin="0" aria-valuemax="100" style="width:${repartition[2]/count * 100}%">
                            <span class="">${repartition[2]/count * 100}%</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="mood">
                <div class="img-container">
                    <img src="resources/img/4.png" alt="super"/>
                </div>
                <div class="progress-bar-container">
                    <span class="desc">Vote count: ${repartition[3]}</span>
                    <div class="progress">
                        <div class="progress-bar progress-bar-midsuccess" role="progressbar" aria-valuenow="45"
                             aria-valuemin="0" aria-valuemax="100" style="width:${repartition[3]/count * 100}%">
                            <span class="">${repartition[3]/count * 100}%</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="mood">
                <div class="img-container">
                    <img src="resources/img/5.png" alt="super"/>
                </div>
                <div class="progress-bar-container">
                    <span class="desc">Vote count: ${repartition[4]}</span>
                    <div class="progress">
                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="25"
                             aria-valuemin="0" aria-valuemax="100" style="width:${repartition[4]/count * 100}%">
                            <span class="">${repartition[4]/count * 100}%</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="half-2">

        <div class="global">
            <div class="global-mood">
              <div class="img-container">
                <img class="mood" src="resources/img/${round}.png" alt=""/>
              </div>
              <div class="notation">
                  <p class="title">GLOBAL MOOD</p>
                  <span class="note">${average}</span>
                  <span class="note-on">/5</span>
              </div>
            </div>
        </div>

        <div class="comments">
            <h2 class="title">Comments</h2>
            <c:forEach items="${moods}" var="mood" varStatus="loop">
                <c:if test="${mood.comment != null && mood.isPublic()}">

                    <div class="comment-container">
                        <div class="note">
                            <img class="mood" src="resources/img/${mood.grade}.png" alt=""/>
                        </div>
                        <div class="comment">
                            ${mood.comment}
                        </div>
                    </div>

                    </c:if>
                    </c:forEach>
        </div>
    </div>
</div>

<!-- jQuery -->
<script src="resources/js/jquery-3.1.1.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="resources/js/bootstrap.min.js"></script>

</body>

</html>
