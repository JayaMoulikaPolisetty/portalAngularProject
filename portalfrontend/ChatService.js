HomeModule.factory("ChatService",function($http) {

var chatService=this;





chatService.sendMessage = function(msg,client){
  client.send("/app/chat/",{},JSON.stringify(msg))


   return chatService.message;

}



return chatService;
})
