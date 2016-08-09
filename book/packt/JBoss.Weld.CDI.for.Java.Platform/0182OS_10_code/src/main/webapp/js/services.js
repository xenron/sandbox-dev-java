'use strict';

/* Services */

angular.module('category.services', ['ngResource']).
    factory('Category', function ($resource) {
        return $resource('/chapter10/rest/categories');
    });

angular.module('book.services', ['ngResource']).
    service('Book', function ($resource) {
        this.getBooks = function () {
            return $resource('/chapter10/rest/books').query();
        };
        this.getBooksByCategory = function (categoryId) {
            return $resource('/chapter10/rest/books/:categoryId')
                .query({
                    "categoryId" : categoryId
                });
        };
        this.getBook = function (bookId) {
            return $resource('/chapter10/rest/book/:bookId')
                .get({
                    "bookId" : bookId
                });
        };
    });

angular.module('user.services', ['ngResource']).
    service('User', function ($resource) {

        var loadUser = function (success) {
            $resource('/chapter10/rest/account').get(function (userData) {
                if (userData.userId) {
                    if (success) {
                        success(userData);
                    }
                }
            });
        };
        this.register = function (user, success, error) {
            $resource('/chapter10/rest/account/register').save(user, function (response) {
                if (response.success) {
                    success();
                } else {
                    error();
                }
            }, error);
        };
        this.login = function (user, success, error) {
            $resource('/chapter10/rest/account/login').save({
                email : user.email,
                password : user.password
            }, function (response) {
                if (response.success) {
                    loadUser(success);
                } else {
                    error();
                }
            }, error);
        };
        this.logout = function () {
            $resource('/chapter10/rest/account/logout').get();
        };
    });
