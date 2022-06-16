package com.example.doanmobile.fragment

import com.example.doanmobile.GlobalVar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.walletconnect.Session
import kotlin.coroutines.Continuation
import kotlin.coroutines.suspendCoroutine

class KTFunc(private val dispatchers: Dispatchers) {
   public suspend fun performTransaction(
            address: String,
            value: String,
            data: String?,
            nonce: String?,
            gasPrice: String?,
            gasLimit: String?,
    ): Session.MethodCall.Response {
        return withContext(dispatchers.IO) {
            suspendCoroutine { continuation ->
                GlobalVar.getInstance().walletConnectKit.address?.let { fromAddress ->
                    GlobalVar.getInstance().walletConnectKit.session.let { session ->
                        val id = System.currentTimeMillis()
                        GlobalVar.getInstance().walletConnectKit.session?.performMethodCall(
                                Session.MethodCall.SendTransaction(
                                        id,
                                        fromAddress,
                                        address,
                                        nonce,
                                        gasPrice,
                                        gasLimit,
                                        value,
                                        data ?: ""
                                )
                        ) { response -> onResponse(id, response, continuation) }
                        GlobalVar.getInstance().walletConnectKit.openWallet()
                    } ?: continuation.resumeWith(Result.failure(Throwable("Session not found!")))
                } ?: continuation.resumeWith(Result.failure(Throwable("Address not found!")))
            }
        }
    }
    fun onResponse(
            id: Long,
            response: Session.MethodCall.Response,
            continuation: Continuation<Session.MethodCall.Response>
    ) {
        if (id != response.id) {
            val throwable = Throwable("The response id is different from the transaction id!")
            continuation.resumeWith(Result.failure(throwable))
            return
        }
        response.error?.let {
            continuation.resumeWith(Result.failure(Throwable(it.message)))
        } ?: continuation.resumeWith(Result.success(response))
    }

     fun handleResponse(resp: Session.MethodCall.Response) {
       System.out.println(((resp.result as? String) ?: "Unknown response"));
    }
}