'use strict';

/* Controllers */

function CategoryListCtrl($scope, Category) {
    $scope.categories = Category.query();
}

function BookListCtrl($scope, $routeParams, $location, Book) {
    $scope.loadDetail = function (book) {
        $location.path('/book/' + book.id);
    };

    if ($routeParams.categoryId !== undefined && $routeParams.categoryId !== null) {
        $scope.books = Book.getBooksByCategory($routeParams.categoryId);
    } else {
        $scope.books = Book.getBooks();
    }
}

function BookDetailCtrl($scope, $routeParams, Book) {
    if ($routeParams.bookId !== undefined) {
        $scope.book = Book.getBook($routeParams.bookId);
    }
}

function UserCtrl($scope, User, $location) {

    $scope.user = {
        userId : null,
        email : null,
        name : null,
        password : null,
        role : null,
        loggedIn : false
    };

    $scope.login = function () {
        $scope.failed = false;
        User.login($scope.user, function (userData) {
            $scope.user.userId = userData.userId;
            $scope.user.email = userData.email;
            $scope.user.name = userData.name;
            $scope.user.role = userData.role;
            $scope.user.loggedIn = true;
            $scope.user.password = null;

            $('#loginModal').modal('hide');
            $location.path('/books');
        }, function () {
            $scope.failed = true;
        });
    };

    $scope.logout = function () {
        $scope.user.email = null;
        $scope.user.password = null;
        $scope.user.loggedIn = false;
        User.logout();
    };
}

function RegisterCtrl($scope, User) {
    $scope.u = {};

    $scope.register = function () {
        $scope.registered = false;
        $scope.failed = false;

        User.register($scope.u, function(response) {
            $scope.registered = true;
            $scope.u = {};
        }, function () {
            $scope.failed = true;
        });
    }
}