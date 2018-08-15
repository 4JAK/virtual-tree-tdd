// This is so IE stops complaining when running tests
(function () {
  if (typeof NodeList.prototype.forEach === 'function') {
    return false;
  }
  NodeList.prototype.forEach = Array.prototype.forEach;
}());
