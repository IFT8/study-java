<html>
<head>
    <title>Welcome!</title>
</head>
<body>
<h1>Welcome <#if '${user}' == 'Big Joe'> ${user} <#else> assupg </#if>, our beloved leader!</h1>

<p>Our latest product:<a href="${latestProduct.url}">${latestProduct.name}</a>!
</body>
</html>