(ns practicalli.status-monitor-service-test
  (:require [clojure.test :refer [deftest is testing]]
            [ring.mock.request :as  mock]
            [practicalli.status-monitor-service :as status-monitor]))

(deftest dashboard-test
  (testing "Testing elements on the dashboard"
    (is (= (status-monitor/dashboard (mock/request :get "/"))
           {:status  200
            :body    "Status Monitor Dashboard via CircleCI and Heroku"
            :headers {}}))))
