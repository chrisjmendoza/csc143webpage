<?php
if ($_POST["submit"]) {
    $name = $_POST['name'];
    $email = $_POST['email'];
    $message = $_POST['message'];
    $human = intval($_POST['human']);
    $from = 'CSC143 Feedback';
    $to = 'chris@cjinseattle.com';
    $subject = 'Message from CSC143 Feedback Page ';

    $body ="From: $name\n E-Mail: $email\n Message:\n $message";
    // Check if name has been entered
    if (!$_POST['name']) {
        $errName = 'Please enter your name';
    }

    // Check if email has been entered and is valid
    if (!$_POST['email'] || !filter_var($_POST['email'], FILTER_VALIDATE_EMAIL)) {
        $errEmail = 'Please enter a valid email address';
    }

    //Check if message has been entered
    if (!$_POST['message']) {
        $errMessage = 'Please enter your message';
    }
    //Check if simple anti-bot test is correct
    if ($human !== 5) {
        $errHuman = 'Your anti-spam is incorrect';
    }
    // If there are no errors, send the email
    if (!$errName && !$errEmail && !$errMessage && !$errHuman) {
        if (mail ($to, $subject, $body, $from)) {
            $result='<div class="alert alert-success">Thank You! I will be in touch</div>';
        } else {
            $result='<div class="alert alert-danger">Sorry there was an error sending your message. Please try again later.</div>';
        }
    }
}
                    ?>
<!doctype html>
<html>
    <head>
        <title>CSC143 - Feedback</title>
        <meta charset="utf-8" />
        <meta name="robots" content="noindex,nofollow" />
        <link href="css/style.css" type="text/css" rel=stylesheet />
        <link href="css/nav.css" type="text/css" rel="stylesheet" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
        <script src="js/script.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    </head>

    <body>

        <header>
            <a href="http://www.java.com/en/"><img id="logo" src="images/iconjava.gif" alt="Java" title="Java Homepage" height="62"/></a>
            <h1><a href="index.html">CSC143 - Java II</a></h1>
            <p class="header">Computer Programming for Engineers and Scientists</p>

            <nav id='cssmenu'>
                <ul>
                    <li><a href="index.html">Home</a></li>
                    <li><a href='#'>Class Resources</a>
                        <ul>
                            <li><a href="calendar.html">Calendar</a></li>
                            <li><a href="classnotes.html">Class Notes</a></li>
                            <li><a href="hw.html">Homework</a>
                                <ul>
                                    <li><a href="hw/hw1.html">Homework 1</a></li>
                                    <li><a href="hw/hw2.html">Homework 2</a></li>
                                    <li><a href="hw/hw3.html">Homework 3</a></li>
                                    <li><a href="hw/hw4.html">Homework 4</a></li>
                                    <li><a href="hw/hw5.html">Homework 5</a></li>
                                    <li><a href="hw/hw6.html">Homework 6</a></li>
                                    <li><a href="hw/hw7.html">Homework 7</a></li>
                                    <li><a href="hw/hw7ExtraCredit.html">Homework 7 - Extra Credit</a></li>
                                </ul>
                            </li>
                            <li><a href="programs.html">Programs</a></li>
                            <li><a href="syllabus.html">Syllabus</a></li>
                        </ul>
                    <li><a href="resources.html">Resources</a></li>

                    <li class='active'><a href="#">Feedback</a></li>
                </ul>
            </nav>
        </header>

        <div class="container">
            <div class="row">
                <div class="contactform">
                    <h1>Contact Form</h1>
                    <form role="form" method="post" action="feedback.php">
                        <div class="form-group">
                            <label for="name" class="col-sm-2 control-label">Name</label>
                            <div class="inputs">
                                <input type="text" class="form-control" id="name" name="name" placeholder="First & Last Name" value="<?php echo htmlspecialchars($_POST['name']); ?>">
                                <?php echo "<p class='text-danger'>$errName</p>";?>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="email" class="col-sm-2 control-label">Email</label>
                            <div class="col-sm-10">
                                <input type="email" class="form-control" id="email" name="email" placeholder="email@domain.com" value="<?php echo htmlspecialchars($_POST['email']); ?>">
                                <?php echo "<p class='text-danger'>$errEmail</p>";?>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="message" class="control-label">Message</label>
                            <div class="col-sm-10">
                                <textarea class="form-control" rows="4" name="message" id="message"><?php echo htmlspecialchars($_POST['message']);?></textarea>
                                <?php echo "<p class='text-danger'>$errMessage</p>";?>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="human" class="col-sm-2 control-label">2 + 3 = ?</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="human" name="human" placeholder="Your Answer">
                                <?php echo "<p class='text-danger'>$errHuman</p>";?>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-10 col-sm-offset-2">
                                <input id="submit" name="submit" type="submit" value="Send" class="btn btn-primary">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-10 col-sm-offset-2">
                                <?php echo $result; ?>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

                    <footer>
                        <small>
                            &copy; 2015, All Rights Reserved ~ Seattle Central College ~
                            <a href="http://validator.w3.org/check/referer" target="_blank">Valid&nbsp;HTML</a> ~
                            <a href="http://jigsaw.w3.org/css-validator/check?uri=referer" target="_blank">Valid&nbsp;CSS</a> ~ Authored by <a href="http://www.cjinseattle.com">Chris Mendoza</a> ~ <a href="disclaimer.html">Disclaimer</a>
                        </small>
                    </footer>
                    </body>
                </html>
