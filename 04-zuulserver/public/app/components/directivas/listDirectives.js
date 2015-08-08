angular.module('tiendaAngular.components.directivas', [])
.directive('backImg', function() {
        return {
          restrict: 'A',
          link: function(scope, element, attrs) {
            attrs.$observe('backImg', function(url) {

            element.css({
              'background-image': 'url(' + url + ')',
              'background-size': 'cover'
            });
            });
          }
        };
      });
