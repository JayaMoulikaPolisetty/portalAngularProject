HomeModule.controller("FriendController", function($scope, $location, $rootScope,$cookieStore,$filter,FriendService){

  $scope.friendrequests = function() {

      FriendService.friendrequests($rootScope.userdetails.username).then(function(response){
        // $cookieStore.put('friendrequests', response.data);
        // $rootScope.requests = $cookieStore.get('friendrequests')
        // console.log(response.data);

        $scope.requests = response.data;

        FriendService.friends($rootScope.userdetails.username).then(function(response){
          // console.log(response.data);
          // $cookieStore.put('friendsList',response.data);
          // $rootScope.friends = $cookieStore.get('friendsList')
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
      // console.log(response.data);
      // $cookieStore.put('suggestedList', response.data)
      // $rootScope.suggested = $cookieStore.get('suggestedList');
      $scope.suggested = response.data
    }),function(response) {
      console.log(response.data);
    }
  }

  $scope.sendRequest = function(sendTo, index) {
    var friend = {}
    friend.sentUser = $rootScope.userdetails.username;
    friend.receivedUser = sendTo;
    friend.status = 0;
    FriendService.sendRequest(friend).then(function(response){
      $scope.suggested.splice(index,1);
      $location.path("/moreFriends")
    }),function(response) {
      console.log(response.data);
    }
  }

  $scope.acceptRequest = function(send, index) {
    var friend = {}
    friend.receivedUser = $rootScope.userdetails.username;
    friend.sentUser = send;
    FriendService.acceptRequest(friend).then(function(response) {
      $scope.requests.splice(index,1);
      $scope.friends.push(response.data.sentUser)
      $location.path("/friend")
    }), function(response) {
      console.log(response.data);
    }
  }

  $scope.rejectRequest = function(send,index) {
    var friend = {}
    friend.receivedUser = $rootScope.userdetails.username;
    friend.sentUser = send;
    FriendService.rejectRequest(friend).then(function(response) {
      $scope.requests.splice(index,1);
      $location.path("/friend")
    }), function(response) {
      console.log(response.data);
    }
  }
})
