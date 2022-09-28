import { createRouter, createWebHistory } from 'vue-router'
import Login from "@/views/Login";
import Client from "@/views/Client";
import Operator from "@/views/Operator";
import PurchaseOrders from "@/views/PurchaseOrders";
import SalesOrders from "@/views/SalesOrders";
import Supplier from "@/views/Supplier"
import Warehouse from "@/views/Warehouse"
import TakeOver from "@/components/TakeOver";
import ProcessingCenter from "@/views/ProcessingCenter"

const routes = [
  {
    path: '/',
    name: 'login',
    components: {
      LoginHome: Login
    }
  },
  {
    path: '/takeOver',
    name: 'takeOver',
    components: {
      LoginHome: TakeOver
    },
    children: [
      {
        path: '/processingCenter',
        name: 'processingCenter',
        components: {
          MainBody: ProcessingCenter
        }
      },
      {
        path: '/client',
        name: 'client',
        components: {
          MainBody: Client
        }
      },
      {
        path: '/operator',
        name: 'operator',
        components: {
          MainBody: Operator
        }
      },
      {
        path: '/purchaseOrders',
        name: 'purchaseOrders',
        components: {
          MainBody: PurchaseOrders
        }
      },
      {
        path: '/salesOrders',
        name: 'salesOrders',
        components: {
          MainBody: SalesOrders
        }
      },
      {
        path: '/supplier',
        name: 'supplier',
        components: {
          MainBody: Supplier
        }
      },
      {
        path: '/warehouse',
        name: 'warehouse',
        components: {
          MainBody: Warehouse
        }
      },
    ]
  },





]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
