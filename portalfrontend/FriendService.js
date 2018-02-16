HomeModule.factory('FriendService', function($http){

var BASE_URL = "http://localhost:8089/portalmiddleware"
var friendService = {}

friendService.friendrequests = function(username) {
  console.log(username);
    return $http.get(BASE_URL+"/friendrequests?username="+username);
}

friendService.friends = function(username) {
  console.log(username);
    return $http.get(BASE_URL+"/friends?username="+username);
}
friendService.suggestedFrnds = function(username) {
  console.log(username);
    return $http.get(BASE_URL+"/suggested?username="+username);
}

friendService.sendRequest = function(friend){
  return $http.post(BASE_URL+"/sendRequest",friend);
}
friendService.acceptRequest = function(friend){
  return $http.post(BASE_URL+"/acceptRequest",friend);
}
friendService.rejectRequest = function(friend){
  return $http.post(BASE_URL+"/rejectRequest",friend);
}
return friendService;
})
