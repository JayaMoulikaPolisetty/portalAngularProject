HomeModule.controller("FriendController", function($scope, $location, $rootScope,$cookieStore,$filter,FriendService){

  $scope.friendrequests = function() {

      FriendService.friendrequests($rootScope.userdetails.username).then(function(response){
        $cookieStore.put('friendrequests', response.data);
        $rootScope.requests = $cookieStore.get('friendrequests')
        console.log(response.data);

        // $scope.requests = response.data;

        FriendService.friends($rootScope.userdetails.username).then(function(response){
          console.log(response.data);
          $cookieStore.put('friendsList',response.data);
          $rootScope.friends = $cookieStore.get('friendsList')
          $scope.friends = response.data;
        }),function(response) {
          console.log(response.data);
        }
      }),function(response) {
        console.log(response.data);
      }
  }

  $scope.suggestedFrnds = function() {
    FriendService.suggestedFrnds($rootScope.userdetails.username).then(function(response){
      console.log(response.data);
      $cookieStore.put('suggestedList', response.data)
      $rootScope.suggested = $cookieStore.get('suggestedList');
    }),function(response) {
      console.log(response.data);
    }
  }

  $scope.sendRequest = function(sendTo) {
    var friend = {}
    friend.sentUser = $rootScope.userdetails.username;
    friend.receivedUser = sendTo;
    friend.status = 0;
    FriendService.sendRequest(friend).then(function(response){
      $location.path("/moreFriends")
    }),function(response) {
      console.log(response.data);
    }
  }
})
