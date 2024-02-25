<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Welcome Onboard Email</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
    }
    .container {
      max-width: 600px;
      margin: 0 auto;
      padding: 20px;
      border: 1px solid #ccc;
    }
    h1 {
      margin-top: 0;
    }
    p {
      margin-bottom: 20px;
    }
    .info {
      background-color: #f4f4f4;
      padding: 10px;
      margin-bottom: 20px;
    }
    .info p {
      margin-bottom: 5px;
    }
    .btn {
      display: inline-block;
      padding: 8px 12px;
      background-color: #007bff;
      color: #fff;
      text-decoration: none;
      border-radius: 4px;
    }
  </style>
</head>
<body>
  <div class="container">
    <h1>Welcome Onboard!</h1>
    <p>Dear <strong>${ name }</strong>,</p>
    <p>Welcome to the online exam platform. We are excited to have you as a new student.</p>
    <div class="info">
      <p><strong>Username:</strong> ${ Username }</p>
      <p><strong>Password:</strong> ${ Password }</p>
    </div>
    <p>Please use the provided credentials to log in and access your exams.</p>
    <p>If you have any questions or need further assistance, please don't hesitate to reach out to our support team.</p>
    <p>Best regards,</p>
    <p>The Online Exam Team</p>
    <p>
      <a href=${link} class="btn">Login here</a>
    </p>
  </div>
</body>
</html>
