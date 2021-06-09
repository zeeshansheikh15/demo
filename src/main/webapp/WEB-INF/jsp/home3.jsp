<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello jsp</title>
<script src="https://cdn.socket.io/3.1.3/socket.io.min.js" integrity="sha384-cPwlPLvBTa3sKAgddT6krw0cJat7egBga3DJepJyrLl4Q9/5WLra3rrnMcyTyOnh" crossorigin="anonymous"></script>
<script type="text/javascript">

function NodeBookConnect(){
console.log('Book Connection started');
		ndbooksocket = io.connect('http://142.93.218.10:3000', {transports: ['websocket']});
		ndbooksocket.on('connect', () => {
		console.log('Book Connection Established');
		});

		ndbooksocket.on('disconnect', () => {
	  console.log('Book Connection Closed');
	  NodeBookConnect();
	});
	}

        </script>
</head>
<body onload="NodeBookConnect()">

    <h2 class="hello-title">Hello jsp count is  zzzzzzzzzzzzzzzzzzz</h2>

</body>
</html>

