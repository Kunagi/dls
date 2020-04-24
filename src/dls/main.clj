(ns dls.main
  (:require
   [kcu.sapp-init]
   [kcu.sapp :as sapp]

   [kunagi-base.modules.startup.api :as startup]

   ;; load kunagi-base modules
   [kunagi-base-server.modules.http-server.model]
   [kunagi-base-server.modules.browserapp.model]

   [dls.appinfo :refer [appinfo]]))


(sapp/set-default-config
 {:http-server/oauth {:google {:enabled? false}}})

(sapp/set-appinfo appinfo)

(defn -main []
  (startup/start! {:app/info appinfo})
  (sapp/start))

