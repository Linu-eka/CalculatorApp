package com.example.calculatorapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.lang.Math.pow
import kotlin.math.log
import kotlin.math.sqrt

class CalculatorViewModel: ViewModel() {
    var state by mutableStateOf(CalculatorState())
        private set

    fun onAction(action: CalculatorAction){
        when(action){
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Clear -> state = CalculatorState()
            is CalculatorAction.Operation -> enterOperation(action.operation)
            is CalculatorAction.Calculate -> performCalculation()
            is CalculatorAction.Delete -> performDeletion()
        }
    }

    private fun enterNumber(number:Int){
        if(state.operation == null){
            if(state.number1.length >= MAX_NUM_LENGTH){
                return
            }
            state = state.copy(
                number1 = state.number1 + number
            )
            return
        }
        if(state.number2.length >= MAX_NUM_LENGTH){
            return
        }
        state = state.copy(
            number2 = state.number2 + number
        )
    }
    private fun performDeletion() {
        when {
            state.number2.isNotBlank() -> state = state.copy(
                number2 = state.number2.dropLast(1)
            )
            state.operation != null -> state = state.copy(
                operation = null
            )
            state.number1.isNotBlank() -> state = state.copy(
                number1 = state.number1.dropLast(1)
            )
        }

    }

    private fun performCalculation() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        if(number1 != null && number2 != null){
            val result = when(state.operation){
                is CalculatorOperation.Add -> number1 + number2
                is CalculatorOperation.Subtract -> number1 - number2
                is CalculatorOperation.Multiply -> number1 * number2
                is CalculatorOperation.Divide -> number1 / number2
                is CalculatorOperation.Root -> number1 * sqrt(number2)
                is CalculatorOperation.log -> log(number2,10.00)
                is CalculatorOperation.Power -> pow(number1,number2)
                null -> return
            }
            state = state.copy(
                number1 = result.toString().take(15),
                number2 = "",
                operation = null

            )
        }
        else if(number2 != null && state.operation == CalculatorOperation.Root){
            val result = sqrt(number2)
            state = state.copy(
                number1 = result.toString().take(15),
                number2 = "",
                operation = null
            )

        }
        else if(number2 != null && state.operation == CalculatorOperation.log){
            val result = log(number2, 10.00)
            state = state.copy(
                number1 = result.toString().take(15),
                number2 = "",
                operation = null
            )
        }

    }

    private fun enterOperation(operation: CalculatorOperation) {
        if(state.number1.isNotBlank()){
            state = state.copy(operation = operation)
        }
        else if(state.number1.isBlank() && operation == CalculatorOperation.Root){
            state = state.copy(operation = operation)
        }
        else if(state.number1.isBlank() && operation == CalculatorOperation.log){
            state = state.copy(operation = operation)
        }

    }

    private fun enterDecimal() {
        if(state.operation == null && !state.number1.contains(".")
            && state.number1.isNotBlank()
            ) {
            state = state.copy(
                number1 = state.number1 + "."
            )
            return

        }
        if(!state.number2.contains(".")
            && state.number2.isNotBlank()
        ) {
            state = state.copy(
                number2 = state.number2 + "."
            )


        }


    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }


}