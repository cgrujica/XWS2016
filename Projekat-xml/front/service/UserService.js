app.service('UserService', function($http){
    return {
        signIn: function(email, password, callback){
            $http.post('/login', {
                email: email,
                password: password
            }, {
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded',
                },
                transformRequest: function(obj) {
                    var str = [];
                    for(var p in obj)
                        str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
                    return str.join("&");
                }
            }).success(function (response) {
                    // ukoliko postoji token, prijava je uspecna
                    if (response.token) {
                        // korisnicko ime, token i rola (ako postoji) cuvaju se u lokalnom skladištu
                        var currentUser = { username: username, token: response.token }
                       
                        $localStorage.currentUser = currentUser;
                        // callback za uspesan login
                        callback(true);
                        $state.go('main');
                    } else {
                        // callback za neuspesan login
                        callback(false);
                    }
                });
        },
        logout: function(onSuccess, onError){
            delete $localStorage.currentUser;
            $state.go('login');
        }
    }
});