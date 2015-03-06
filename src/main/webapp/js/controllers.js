var elibraryApp = angular.module('elibraryApp', []);

elibraryApp.controller('BooksListCtrl', function($scope, $http) {
	$http.get('app/rest/book').success(function(data) {
		$scope.books = data;
	})
});