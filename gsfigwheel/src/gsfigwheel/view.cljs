(ns gsfigwheel.view
  (:require [accountant.core :as accountant]
            [rum.core :as rum]
            [gsfigwheel.flow :as flow]))

(rum/defc +home < rum/reactive [state]
  [:.content
   [:p "Current state:" (str (rum/react state))]
   [:p "Click count:" (:count (rum/react state))]
   [:button.button.is-link {:on-click #(flow/dispatch :increment-counter)} "Click me!"]])

(rum/defc +about [state]
  [:.card
   [:.card-content
    [:p "This is about page."]]])

(rum/defc +app < rum/reactive [state]
  [:div
   [:.tabs
    [:ul
     [:li [:a {:href "/index.html" :on-click #(accountant/navigate! "/index.html")} "Home"]]
     [:li [:a {:href "/about.html" :on-click #(accountant/navigate! "/about.html")} "About"]]]]
   ((:handler (rum/react state)) state)])
