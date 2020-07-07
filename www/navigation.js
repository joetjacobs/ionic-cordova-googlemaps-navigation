var execute = require("cordova/exec");

var navigation = {

  navigate:function(location, success, failure){
      return execute(success, failure, 'NavigationPlugin', 'navigate', [location]);
    }
};
module.exports = navigation;
