(ns practicalli.status-monitor-service
  (:gen-class)
  (:require [compojure.core :refer [defroutes GET]]
            [org.httpkit.server :as app-server]))


;; Application routing
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defroutes status-monitor
  (GET "/" [] {:status 200 :body "Status Monitor Dashboard"}))


;; System
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; Running state of the application server
(defonce app-server-instance (atom nil))

(defn stop-app-server
  "Gracefully shutdown the server, waiting 100ms"
  []
  (when-not (nil? @app-server-instance)
    (@app-server-instance :timeout 100)
    (reset! app-server-instance nil)
    (println "INFO: Application server stopped")))


(defn -main
  "Start the application server and run the application"
  [& {:keys [port]
      :or   {port 8888}}]
  (println "INFO: Starting server on port: " port)

  (reset! app-server-instance
          (app-server/run-server #'status-monitor {:port port})))


(defn restart-app-server
  "Convenience function to stop and start the application server"
  []
  (stop-app-server)
  (-main))



;; REPL Driven Development - useful function calls
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(comment

  ;; start application
  (-main)

  ;; stop application
  (stop-app-server)

  ;; restart application
  (restart-app-server)

  )
