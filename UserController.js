myApp.controller("UserController",function($scope,$rootScop,$http,$location,$cookieStore))
{
   $scope.User={loginname:'',password:'',userName:'',emailId:'',mobileNo:'',addres:'',role:''};
   
   $scop.register=function()
   {
	   console.log('Entered into the Register Function');
	   
	   $http.post('http://localhost:8086/ChatMiddleware/registerUser',$scope.User')
			.then(function(response)
			{
		     console.log('Registration Completed');
		     console.log(responce statusText);
		     $location.path("login");
			});
   }
   $scope.login=function()
   {
	   console.log('Enter into the Function');
	   $http.post('http://localhost:8086/ChatMiddleware/checkLogin',$scope.user)
	   .then(function(response)
			{
		     $scope.User =response.data;
		     $rootScope.currentUser=responce.data;
		     $CookieStore.put('userDetails',responce.data);
		     $location.path("/UserHome");
			})
 			}
   });
}
		