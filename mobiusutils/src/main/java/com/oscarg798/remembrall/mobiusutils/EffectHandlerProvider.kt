package com.oscarg798.remembrall.mobiusutils

import com.spotify.mobius.Connectable

interface EffectHandlerProvider<Effect, Event> {

    fun provide(uiEffectConsumer: EffectConsumer<Effect>): Connectable<Effect, Event>
}
