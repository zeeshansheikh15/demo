<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello jsp</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/socket.io/2.3.0/socket.io.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){
NodeBookConnect();
});

function NodeBookConnect(){
	var Parent = "Event/Auto";
    var data =  "30424356";
	var SocketUrl = Parent+'/'+data;
	console.log(SocketUrl)
	
	var ndbooksocket = io('http://142.93.218.10:3000', {transports: ['websocket']});
		ndbooksocket.on('connect', () => {
		console.log('Book Connection Established');
		});

    ndbooksocket.emit(Parent, data);

	ndbooksocket.on(SocketUrl, (message) => {
			 console.log(message);
			 });

	ndbooksocket.on('disconnect', () => {
	  console.log('Book Connection Closed');
	  NodeBookConnect();
	    });
	}

</script>
</head>
<body >

    <h2 class="hello-title">Hello jsp count is  zzzzzzzzzzzzzzzzzzz</h2>

</body>
</html>

