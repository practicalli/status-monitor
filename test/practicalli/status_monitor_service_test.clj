(ns practicalli.status-monitor-service-test
  (:require [clojure.test :refer [deftest is testing]]
            [ring.mock.request :as  mock]
            [practicalli.status-monitor-service :as SUT]))

(deftest dashboard-test
  (testing "Testing elements on the dashboard"
    (is (= (SUT/dashboard (mock/request :get "/"))
           {:status  200
            :body    "Status Monitor Dashboard"
            :headers {}}))))
