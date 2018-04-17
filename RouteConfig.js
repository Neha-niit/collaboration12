var myApp=angular.module("myApp",['ngRoute','ngCookies'']);

myApp.config(function($routeProvider)
{
	alert("Route Provider");
	$routeProvider.when("/",{templateUrl:"/index.html"})
					.when("/login",{templateUrl:"template/Login.html"})
					.when("/register",{templateUrl:"template/Register.html"})
					.when("/aboutUs",{templateUrl:"template/AboutUs.html"})
					.when("/contactUs",{templateUrl:"template/ContactUs.html"})
					.when("/UserHome",{templateUrl:"c_user/UserHome.html"})
					.when("/blog",{templateUrl:"c_blog/Blog.html"})
					
});
myApp.run(function($rootscope,$cookieStore)
{
      console.log('I am in Run Function');
      
      console.log($rootscope.currentUser);
      
      if($rootscope.currentUser==undefined)
   	  {
    	  $rootscope.currentUser=$cookieStore.get('userDetails'); 
   	  }
      
      

}		
