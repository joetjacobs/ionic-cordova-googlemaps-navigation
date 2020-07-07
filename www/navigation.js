var execute = require("cordova/exec");

var navigation = {

  navigate:function(success,failure){
      return execute(success,failure,'NavigationPlugin', 'navigate', []);
    }
};
module.exports = navigation;
