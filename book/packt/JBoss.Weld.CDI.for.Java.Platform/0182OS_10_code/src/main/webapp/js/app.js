'use strict';


// Declare app level module which depends on filters, and services
angular.module('mybooks', ['category.services', 'book.services', 'user.services']).
  config(['$routeProvider', function ($routeProvider) {
    $routeProvider.
        when('/books', {
            templateUrl: 'partials/book-list.html',
            controller: BookListCtrl
        }).
        when('/books/:categoryId', {
            templateUrl: 'partials/book-list.html',
            controller: BookListCtrl
        }).
        when('/book/:bookId', {
            templateUrl: 'partials/book-detail.html',
            controller: BookDetailCtrl
        }).
        when('/register', {
            templateUrl : 'partials/register.html',
            controller : RegisterCtrl
        }).
        otherwise({redirectTo: '/books'});
  }]);
