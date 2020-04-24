(ns demo.main
  (:require
   [kcu.bapp-init]
   [kcu.bapp :as bapp]

   [kunagi-base.modules.startup.api :as startup]
   [kunagi-base.appmodel :refer [def-module]]
   [kunagi-base-browserapp.modules.desktop.model :refer [def-page]]
   [kunagi-base-browserapp.modules.desktop.api :as desktop]

   [dls.appinfo :refer [appinfo]]))


(def-module
  {:module/id ::demo-browserapp})


(def-page
  {:page/id ::index
   :page/ident :index
   :page/title-text (-> appinfo :project :name)
   :page/workarea [(fn [args] [:div "Hello Datalog"])]})


(defn Desktop []
  [:div "Datalog Server Admin Console"])


(bapp/set-appinfo appinfo)

(defn init []
  ;; (startup/install-serviceworker!)
  (desktop/install-error-handler)
  (startup/start!)
  (bapp/start)
  (bapp/mount-app Desktop))


(defn shadow-after-load []
  (bapp/mount-app Desktop))
