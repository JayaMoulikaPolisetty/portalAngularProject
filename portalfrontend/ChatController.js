HomeModule.controller("ChatController", function($scope,$rootScope,ChatService){


var chatCtrl=this;
chatCtrl.mesg = {}
  chatCtrl.messageList=[];

  var sockjs=new SockJS("http://localhost:8089/portalmiddleware/chat");

  var client=Stomp.over(sockjs);
  client.connect({},function(){
      console.log("connected");
      client.subscribe('/topic/message', function(message) {

        chatCtrl.receiveMessage(message.body);
          chatCtrl.mesg={};
      });
        //client.send("/app/chat/",{},"helllo");
  })


   chatCtrl.receiveMessage=function(message) {
  console.log(message);
     chatCtrl.messageList.push(message);

   }


   $scope.addMessage=function() {
     chatCtrl.messageList.push(chatCtrl.mesg);
   }

  $scope.sendMessage = function() {

    chatCtrl.mesg.username = $rootScope.userdetails.username;

    console.log(chatCtrl.mesg);
  ChatService.sendMessage(chatCtrl.mesg,client);
}

})
