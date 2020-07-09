(ns practicalli.helpers-http)

;; Http related helper functions and data
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def http-status-code
  "Convenience names for http status codes
  https://en.wikipedia.org/wiki/List_of_HTTP_status_codes"

  {:OK 200

   :BAD-REQUEST      400
   :UNORTHORIZED     401
   :PAYMENT-REQUIRED 402
   :FORBIDDEN        403
   :NOT-FOUND        404
   :IM-A-TEAPOT      418

   :INTERNAL-SERVER-ERROR 500
   :NOT-IMPLEMENTED       501
   :BAD-GATEWAY           502
   :SERVICE-UNAVAILABLE   503
   :GATEWAY-TIMEOUT       504})
