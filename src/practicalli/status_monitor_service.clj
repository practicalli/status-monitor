(ns practicalli.status-monitor-service
  (:gen-class)
  (:require
   [org.httpkit.server       :as    app-server]
   [compojure.core           :refer [defroutes GET]]
   [compojure.route          :refer [not-found]]
   [ring.handler.dump        :refer [handle-dump]]
   [ring.util.response       :refer [response]]
   [practicalli.helpers-http :refer [http-status-code]]))



;; Request handlers
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn dashboard
  [request]
  {:status (:OK http-status-code) :body "Status Monitor Dashboard" :headers {}})

;; Application routing
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defroutes status-monitor
  (GET "/" [] dashboard)
  (GET "/request-dump" [] handle-dump)
  )


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
  [port]
  (println "INFO: Starting server on port: " port)

  (reset! app-server-instance
          (app-server/run-server #'status-monitor {:port (Integer/parseInt port)})))


(defn restart-app-server
  "Convenience function to stop and start the application server"
  []
  (stop-app-server)
  (-main))



;; REPL Driven Development - useful function calls
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(comment

  ;; start application
  ;; (-main :port 8000)
  (-main 8080)

  ;; stop application
  (stop-app-server)

  ;; restart application
  (restart-app-server)


  ;; Optional port setting approach

  (defn -main
    "Start the application server and run the application"
    [& {:keys [port]
        :or   {port 8888}}]
    (println "INFO: Starting server on port: " port)

    (reset! app-server-instance
            (app-server/run-server #'status-monitor {:port port})))

  ;; original Procfile
  ;; web: java -cp status-monitor-service.jar clojure.main -m practicalli.status-monitor-service $PORT

  )
