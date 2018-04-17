myApp.controller("BlogController",function($scope,$rootScop,$http,$location,$cookieStore))
{
	 $scope.blog={'blogId':0,'blogName':'','blogContent':'','creatDate':'','likes':'','Loginname':'','status':''};
	 
	 $scop.blogdata;
	 
	   $scop.addBlog=function($scope)
	   {
		   console.log('Adding Blog Information');
		   $http.post('http://localhost:8086/ChatMiddleware/addBlog',$scope.Blog')
					.then(function(response)
			{
						console.log('Registration Completed');
					    console.log(responce statusText);
						$location.path('/blog');
			});
	   }; 
	   
	   $scop.listBlog=function($scop)
	   {
		   $http.get('http://localhost:8086/ChatMiddleware/showALLApprovedBlogs') 
		   .then(function(response)
				  {
			        $scop.blogdata=response.data;
				  }); 
	   }
	   listBlog();
 });
