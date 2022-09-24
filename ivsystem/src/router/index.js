import { createRouter, createWebHistory } from 'vue-router'
import Login from "@/views/Login";
import Home from "@/components/Home";
import Client from "@/views/Client";
import Operator from "@/views/Operator";
import PurchaseOrders from "@/views/PurchaseOrders";
import SalesOrders from "@/views/SalesOrders";
import Supplier from "@/views/Supplier"
import Warehouse from "@/views/Warehouse"

const routes = [
  {
    path: '/',
    name: 'login',
    component: Login
  },
  {
    path: '/home',
    name: 'home',
    component: Home
  },
  {
    path: '/client',
    name: 'client',
    component: Client
  },
  {
    path: '/operator',
    name: 'operator',
    component: Operator
  },
  {
    path: '/purchaseOrders',
    name: 'purchaseOrders',
    component: PurchaseOrders
  },
  {
    path: '/salesOrders',
    name: 'salesOrders',
    component: SalesOrders
  },
  {
    path: '/supplier',
    name: 'supplier',
    component: Supplier
  },
  {
    path: '/warehouse',
    name: 'warehouse',
    component: Warehouse
  },




]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
